package org.jlf.soa.mvc.test.action;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;
import org.jlf.soa.mvc.test.bean.QuartzJob;
import org.jlf.soa.mvc.test.bean.QuartzTemplate;
import org.jlf.soa.mvc.test.metadata.QuartzJobSaveReq;
import org.jlf.soa.mvc.test.metadata.QuartzJobTransReq;
import org.jlf.soa.mvc.test.metadata.QuartzJobUpdateReq;
import org.jlf.soa.mvc.test.service.QuartzJobService;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: QuartzJobAction
 * @Description: QuartzJobAction
 * @author Lone Wolf
 * @date 2019年8月11日
 */
@JLFMVCRoute
public class QuartzJobAction {

	private QuartzJobService quartzJobService;

	/**
	 * 
	 * @Title: getQuartzJob
	 * @Description:获取QuartzJob明细信息测试
	 * @param req
	 * @return
	 */
	@JLFMVCRoute(name = "getQuartzJob")
	public QuartzJob getQuartzJob(@JLFCheckAnn Long id) {
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return quartzJobService.getQuartzJob(id);
		//return null;
	}

	/**
	 * 
	 * @Title: getQuartzJobRelate
	 * @Description:获取QuartzJob明细信息,多表之间联查测试
	 * @param id
	 * @return
	 */
	@JLFMVCRoute(name = "getQuartzJobRelate")
	public QuartzJob getQuartzJobRelate(JLFMVCIdRequest req) {
		return quartzJobService.getQuartzJobRelate(req.getId());
	}

	/**
	 * 
	 * @Title: saveQuartzJob
	 * @Description:save方法测试
	 * @param req
	 * @return
	 */
	@JLFMVCRoute(name = "saveQuartzJob")
	public QuartzJob saveQuartzJob(QuartzJobSaveReq req) {
		QuartzJob job = new QuartzJob();
		job.setTemplateId(req.getTemplateId());
		job.setCron(req.getCron());
		return quartzJobService.save(job);
	}

	/**
	 * 
	 * @Title: updateQuartzJob
	 * @Description:update方法测试
	 * @param req
	 */
	@JLFMVCRoute(name = "updateQuartzJob")
	public void updateQuartzJob(QuartzJobUpdateReq req) {
		QuartzJob job = new QuartzJob();
		job.setId(req.getId());
		job.setVersion(req.getVersion());
		job.setTemplateId(req.getTemplateId());
		quartzJobService.update(job);
	}

	/**
	 * 
	 * @Title: deleteQuartzJob
	 * @Description:delete方法测试
	 * @param req
	 */
	@JLFMVCRoute(name = "deleteQuartzJob")
	public void deleteQuartzJob(JLFMVCIdAndVersionRequest req) {
		QuartzJob job = new QuartzJob();
		job.setId(req.getId());
		job.setVersion(req.getVersion());
		quartzJobService.delete(job);
	}

	/**
	 * 
	 * @Title: transQuartzJob
	 * @Description:多数据库之间事物测试
	 * @param req
	 */
	@JLFMVCRoute(name = "transQuartzJob")
	public void transQuartzJob(QuartzJobTransReq req) {
		QuartzJob job = new QuartzJob();
		job.setTemplateId(req.getTemplateId());
		job.setCron(req.getCron());
		QuartzTemplate template = new QuartzTemplate();
		template.setTemplateName(req.getTemplateName());
		template.setClsName(req.getClsName());
		quartzJobService.trans(job, template);
	}

}
