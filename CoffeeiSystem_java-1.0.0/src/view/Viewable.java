package view;

import java.util.Map;

public interface Viewable {

	Viewable execute(Map<String, Object> inputData, Map<String, Object> outputData, Map<String, Object> sharedData);

}
