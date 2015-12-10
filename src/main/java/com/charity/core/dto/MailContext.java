package com.charity.core.dto;

/**
 * User: 20086088
 * Date: 2015/1/8
 * Time: 17:51
 */
public class MailContext {

    /**收件人**/
    private String sendTo;
    /**抄送给**/
    private String ccTo;
    /**邮件主题**/
    private String subject;
    /**邮件内容**/
    private String content;

    public MailContext() {
    }

    /**
     * 构建邮件
     * @param sendTo 发送给
     * @param content 内容
     * @param subject 标题
     */
    public MailContext(String sendTo, String content, String subject) {
        this.sendTo = sendTo;
        this.content = content;
        this.subject = subject;
    }

    /**
     * 构建邮件
     * @param sendTo 发送给
     * @param ccTo 暗抄
     * @param subject 标题
     * @param content 内容
     */
    public MailContext(String sendTo, String ccTo, String subject, String content) {
        this.sendTo = sendTo;
        this.ccTo = ccTo;
        this.subject = subject;
        this.content = content;
    }

    /**附件**/
    //private MultipartFile[] attachment = new MultipartFile[0];

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getCcTo() {
        return ccTo;
    }

    public void setCcTo(String ccTo) {
        this.ccTo = ccTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
