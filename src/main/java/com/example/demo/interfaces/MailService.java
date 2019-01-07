package com.example.demo.interfaces;

public interface MailService {
    /**
     * 发送简单的文本邮件
     *
     * @param to
     *        收件人
     *
     * @param subject
     *        标题
     *
     * @param content
     *        内容
     *
     * @see
     *     @Autowired
     *     private MailService MailService;
     *
     *     @Test
     *     public void testSimpleMail() throws Exception {
     *         MailService.sendSimpleMail("ityouknow@126.com","test simple mail"," hello this is simple mail");
     *     }
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html邮件
     *
     * @param to
     *        收件人
     *
     * @param subject
     *        标题
     *
     * @param content
     *        内容
     *
     * @see
     *      @Test
     *      public void testHtmlMail() throws Exception {
     *         String content="<html>\n" +
     *                 "<body>\n" +
     *                 "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
     *                 "</body>\n" +
     *                 "</html>";
     *         MailService.sendHtmlMail("ityouknow@126.com","test simple mail",content);
     *     }
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送附件邮件
     *
     * @param to
     *        收件人
     *
     * @param subject
     *        标题
     *
     * @param content
     *        内容
     *
     * @param filePath
     *        文件路径
     *
     * @see
     *     @Test
     *     public void sendAttachmentsMail() {
     *         String filePath="e:\\tmp\\application.log";
     *         mailService.sendAttachmentsMail("ityouknow@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
     *     }
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送图片邮件
     *
     * @param to
     *        收件人
     *
     * @param subject
     *        标题
     *
     * @param content
     *        内容
     *
     * @param rscPath
     *        图片路径
     *
     * @param rscId
     *
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
