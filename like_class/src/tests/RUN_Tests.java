package tests;

import tests.LikeControllerTests;

public class RUN_Tests {
    public static void main (String args[]) {

        LikeControllerTests likeControllerTests = new LikeControllerTests();

        likeControllerTests.Create_100LikesSergey_200LikesAndrey();

        // Сюда можно добавлять новые тесты
        // На что еще можно было бы проверить этот класс, кроме как на правильную запись и подсчет лайков,
        // я пока не увидел
        // ...
    }
}
