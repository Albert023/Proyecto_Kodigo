package com.banco.interfaces.interfacesMenu.interfaces;

public interface IManage<T> {
    T changeOption(Class<T> options);

    T manageOptions(Class<T> options);
}