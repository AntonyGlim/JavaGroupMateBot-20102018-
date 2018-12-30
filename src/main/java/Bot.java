import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();                                           //Инициализируем API
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();                //Создаем объект
        //Блок регистрации бота
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод ответа ботом на сообщения
     * @param message
     * @param text
     */
    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();                    //Инициализируем отправленное сообщение
        sendMessage.enableMarkdown(true);                               //Включаем возможность разметки
        sendMessage.setChatId(message.getChatId().toString());          //Установка id чата (чтобы было понятно, куда отправлять)
        sendMessage.setReplyToMessageId(message.getMessageId());        //На какое конкретно сообщение мы должны отвечать
        sendMessage.setText(text);                                      //Устанавливаем текст
        //Отправка сообщения
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Принимает сообщения/обновления (long pool)
     * @param update
     */
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();                          //Обновление бота (получение им информации
        if (message != null && message.hasText()){
            if (message.getText().equals("/help")){
                sendMsg(message, "Чем могу помочь?");
            }
        }
    }

    /**
     * Поможет вернуть имя бота
     * @return
     */
    public String getBotUsername() {
        return "JavaGroupMateBot(20102018)(1)";
    }

    /**
     * Поможет вернуть Token бота
     * @return
     */
    public String getBotToken() {
        return "783854121:AAHgyl9Hj6yAwyGFfmCWyXQuaqPnHu5S2RQ";
    }
}
