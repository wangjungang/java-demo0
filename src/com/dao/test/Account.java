package com.dao.test;

public class Account {

    private int id;
    private String name;
    private int money;

    /**
     * 默认的构造方法
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * 2个参数的构造方法
     * @param id
     * @param money
     */
    public Account(int id, int money) {
        super();
        this.id = id;
        this.money = money;
    }


    /**
     * 3个参数的构造方法
     * @param id
     * @param userName
     * @param money
     */
    public Account(int id, String userName, int money) {
        super();
        this.id = id;
        this.name = userName;
        this.money = money;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



}
