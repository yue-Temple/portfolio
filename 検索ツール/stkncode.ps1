Add-Type -AssemblyName System.Windows.Forms
Add-Type -AssemblyName System.Drawing

# デフォルト検索対象の場所を変更する場合、次のパスを修正する
$adress = "C:\Users\TDM\OneDrive\デスクトップ\検索ツール" 

$folder = 0

 # デフォルト検索対象になっているディレクトリパスを宣言
 Write-Host "アドレス「　$adress　」 内部を検索します"

#フォルダが存在しない場合＝０　フォルダが存在する場合＝１
 while ($folder -eq 0){


 $Name = Read-Host "検索したいフォルダ名を入力してください（部分一致検索）"

 # フォルダ自体の存在確認
 ## 名さえ合っていれば検索をはじめる
 $company = Get-ChildItem -Path $adress -Filter *$Name* -Recurse -Depth 1 | Where-Object{$_.PSIsContainer}


 if($company.count -eq 0){
    Write-Host " "
    Write-Host " "
    Write-Host "フォルダが見つかりません."
    Write-Host "名前が間違っているか、フォルダが未作成です."
    Write-Host "もう一度入力してください..."
    Write-Host " "
     
    
}else{
$folder = 1
}

 }


# フォルダの存在確認からフォルダを開く処理
Function folder_display{
    Param(
        $FolderPath
    )
    if(Test-Path $FolderPath){
        $search_file = $FolderPath
        Invoke-Item $search_file
    }else{
        Write-Host " 「 $FolderPath 」は存在しません．"
        Write-Host "フォルダが削除された可能性があります."
        Write-Host "　　"
        Write-Host "ウィンドウを閉じます...Enterをおしてください."
        $Host.UI.RawUI.ReadKey() 
    　　exit
    }
}

# 検索フォームの生成

## フォームの生成
$form = New-Object System.Windows.Forms.Form
$form.Text = '検索結果一覧'
$form.Size = New-Object System.Drawing.Size(250, 300)
$form.StartPosition = 'CenterScreen'

## ラベルの生成
$label = New-Object System.Windows.Forms.Label
$label.Location = New-Object System.Drawing.Point(10, 10)
$label.Size = New-Object System.Drawing.Size(230, 20)
$label.Text = '該当するクライアント名を選択してください'

## OKボタンの生成
$OKButton = New-Object System.Windows.Forms.Button
$OKButton.Location = New-Object System.Drawing.Point(40, 200)
$OKButton.Size = New-Object System.Drawing.Size(75, 30)
$OKButton.Text = '開く'
$OKButton.DialogResult = [System.Windows.Forms.DialogResult]::OK

## キャンセルボタンの生成
$CancelButton = New-Object System.Windows.Forms.Button
$CancelButton.Location = New-Object System.Drawing.Point(130, 200)
$CancelButton.Size = New-Object System.Drawing.Size(75, 30)
$CancelButton.Text = '閉じる'
$CancelButton.DialogResult = [System.Windows.Forms.DialogResult]::Cancel

## リストボックスの生成
$listBox = New-Object System.Windows.Forms.ListBox
$listBox.Location = New-Object System.Drawing.Point(10, 30)
$listBox.Size = New-Object System.Drawing.Size(210, 150)

## 検索したクライアントのパスをリストボックスに格納
foreach( $c in $company){
    [void] $listBox.Items.Add($c.BaseName)
    $Path = $c.FullName.Replace($c.BaseName, '')
}

## 配置
$form.Controls.Add($label)
$form.Controls.Add($OKButton)
$form.Controls.Add($CancelButton)
$form.Controls.Add($listBox)
$form.AcceptButton = $OKButton
$form.CancelButton = $CancelButton
$form.TopMost = $true

## 表示
$result = $form.ShowDialog()


# 何らかのエラーで失敗したときにtry文でcatchする
try{
    # OKボタンを押したときの処理
    if($result -eq [System.Windows.Forms.DialogResult]::OK){
        # 絶対パスを作成
        $FolderPath = $Path + $listbox.SelectedItem
        # フォルダの表示
        folder_display -FolderPath $FolderPath
    }else{
        exit
    }
}catch{
    Write-Host "実行に失敗しました."
    Read-Host "やり直してください."
}

