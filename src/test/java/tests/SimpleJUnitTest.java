package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;

public class SimpleJUnitTest {
//    @Test
//    void successfulSearchTest () {
//        Selenide.open("https://www.google.com/");
//        $("[name=q]").setValue("selenide").pressEnter();
//        $("[id=search]").shouldHave(text("https://selenide.org/"));
//    }
    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n### beforeAll()\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###   beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###   afterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("### afterAll()\n");
    }

    @Test
    void firstTest() {
        System.out.println("### firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("### secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("### thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}
