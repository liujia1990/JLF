package org.jlf.plugin.server.core.check.custom.detail;

import java.lang.reflect.Field;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: ICheck
 * @Description:Check����
 * @author Lone Wolf
 * @date 2019��5��24��
 * @param <T>
 */
public abstract class ICheck<T extends Object> {

	public static final String NULL_EXCEPTION_DESC = "����Ϊ��";
	public static final String MAX_LENGTH_EXCEPTION_DESC = "���ȳ�����󳤶�����";
	public static final String MIN_LENGTH_EXCEPTION_DESC = "����δ�ﵽ��С��������";
	public static final String MAX_VALUE_EXCEPTION_DESC = "�������ֵ����";
	public static final String MIN_VALUE_EXCEPTION_DESC = "δ�ﵽ��Сֵ����";
	public static final String MAX_DATE_EXCEPTION_DESC = "���������������";
	public static final String MIN_DATE_EXCEPTION_DESC = "δ�ﵽ��С��������";
	public static final String CHECKED_EXCEPTION_DESC = "δ��ָ����Χ��";

	/**
	 * 
	 * @Title: getValue
	 * @Description:�Ӿ���л�ȡfield�ֶε�ֵ
	 * @param json
	 * @param field
	 * @return
	 */
	public abstract T getValue(JLFJson json, Field field);

	/**
	 * 
	 * @Title: checkNull
	 * @Description:У���Ƿ�Ϊ��ֵ
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkNull(JLFCheckAnn ann, Field field, T value) {
		boolean isNull = (ann == null ? JLFCheckAnn.isNull : ann.isNull());
		if (isNull == false && value == null) {
			throw new JLFException(getExceptionDesc(ann, field, NULL_EXCEPTION_DESC));
		}
	}

	/**
	 * 
	 * @Title: getExceptionDesc
	 * @Description:��ȡУ�鲻ͬ��ʱ���쳣��Ϣ
	 * @param ann
	 * @param field
	 * @param exceptionMsg
	 * @return
	 */
	protected String getExceptionDesc(JLFCheckAnn ann, Field field, String exceptionMsg) {
		String fieldDesc = (ann == null ? null : ann.desc());
		if (fieldDesc == null || fieldDesc.length() <= 0) {
			fieldDesc = field.getName();
		}
		return new StringBuffer(fieldDesc).append(exceptionMsg).toString();
	}

}