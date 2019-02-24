package io.arkitekt.mainWorker.operationsMail;


import io.arkitekt.mainWorker.launcherApp;

public class MailHelper{
    //розробка
//    private launcherApp app;
//    private final Wiser wiser;
//
//
//    public MailHelper(launcherApp app) {
//        this.app = app;
//        wiser = new Wiser();
//    }
//
//    public List<MailMessage> waitForMail(int count, long timeout) throws MessagingException, IOException {
//        long start = System.currentTimeMillis();
//        while (System.currentTimeMillis() < start + timeout) {
//            if (wiser.getMessages().size() >= count) {
//                return wiser.getMessages().stream().map((m) -> toModelMail(m)).collect(Collectors.toList());
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        throw new Error("No mail:-(");
//    }
//
//    public static MailMessage toModelMail (WiserMessage m) {
//        try {
//            MimeMessage mm = m.getMimeMessage();
//            return new MailMessage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void start() {wiser.start();}
//
//    public void stop() {wiser.stop();}

}
