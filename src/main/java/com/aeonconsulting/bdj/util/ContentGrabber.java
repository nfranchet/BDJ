package com.aeonconsulting.bdj.util;

import java.util.Map;

public interface ContentGrabber {

	public StringBuffer getContent(Bumper bumper, String url, Map<String,String> headersParams);
}
