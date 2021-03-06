package org.jlf.plugin.server.core.check.suctom.detail.collection;

import java.util.Map;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.CollectionCheck;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: MapCheck
 * @Description:map类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class MapCheck extends CollectionCheck<Map<String, ? extends Object>> {

	@Override
	public Map<String, ? extends Object> getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		JLFJson jsonValue = json.getJson(checkName);
		if(jsonValue == null){
			return null;
		}
		Map<String, Object> map = jsonValue.toMap();
		return map;
	}

	@Override
	protected int getSize(Map<String, ? extends Object> value) {
		return value.size();
	}
}