package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

/**
 * 
 * @ClassName: BigDecimalCheck
 * @Description:BigDecimal����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class BigDecimalCheck extends NumberCheck<BigDecimal> {

	@Override
	public BigDecimal getValue(JLFJson json, Field field) {
		return json.getBigDecimal(field.getName());
	}

}