import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
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
     * Принимает сообщения/обновления (long pool)
     * @param update
     */
    public void onUpdateReceived(Update update) {

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
