package entity;

import java.time.LocalDateTime;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final int score;

    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    CommonUser(String name, String password, int score) {
        this.name = name;
        this.password = password;
        this.score = score;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }



}
