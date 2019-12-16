package ch11;

/**
 * 为了降低Button类 与 Dialer类的强偶合关系，引入ButtonService
 */
public interface ButtonListener {

    void buttonPressed();
}
