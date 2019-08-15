package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: JLFPushSignTool
 * @Description:ǩ������
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public interface JLFPushSignTool {

	/**
	 * 
	 * @Title: sign
	 * @Description:�Է��ͱ��Ľ���ǩ��,�õ�ǩ����ı�������
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 */
	public String sign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req);

	/**
	 * 
	 * @Title: checkSign
	 * @Description:�Է��ر��Ľ�����ǩ
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 */
	public boolean checkSign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req);

}