package tests;

import util.DatabaseManager;
import work.LikeController;
import java.util.*;


public class LikeControllerTests {

    public void Create_100LikesSergey_200LikesAndrey () {

        // Получаю объект который пишет и считает лайки.
        LikeController likeController = new LikeController (DatabaseManager.getLikesCollection()) ;

        //Очищаю коллекцию с лайками
        DatabaseManager.getLikesCollection().drop();

        //Задаю параметры тестирования.
        //Структура такая <На чье имя создавать лайки, Сколько лайков создать>
        Properties prop=new Properties();
        prop.setProperty("Sergey","100");
        prop.setProperty("Andrey","200");

        // В цыкле заполнаю таблицу лайками
        Set<Object> keys = prop.keySet();

        for (Object key : keys) {
            int count = Integer.parseInt (prop.getProperty(key.toString()));
            for(int i = 0; i < count; i++){
                likeController.like(key.toString());
            }
        }

        // В цыкле проверяю как таблица заполнилась лайками
        for (Object key : keys) {
            long count = likeController.getLikes(key.toString());

            // Использовал при отладке
            //System.out.println("Like <"+ key.toString() +">: " + count);

            int sourceCount = Integer.parseInt (prop.getProperty(key.toString()));

            assert  (count == sourceCount);
        }

        System.out.println("Тест <Create_100LikesSergey_200LikesAndrey> = Пройден.");
    }
}
