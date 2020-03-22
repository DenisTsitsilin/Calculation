package ru.dlts.calculation.service;

import ru.dlts.calculation.model.Calculation;

import java.util.List;

public interface CalculationService {

    /**
     * Создает новый расчет
     * @param calculation - расчет для создания
     */
    void create (Calculation calculation);

    /**
     * Возвращает список всех имеющихся расчетов
     * @return список расчетов
     */
    List<Calculation> readAll();

    /**
     * Возвращает расчет по его ID
     * @param id - ID расчета
     * @return - объект расчета с заданным ID
     */
    Calculation read (int id);

    /**
     * Обновляет расчет с заданным ID,
     * в соответствии с переданным расчетом
     * @param calculation - расчет в соответсвии с которым нужно обновить данные
     * @param id - id расчета который нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Calculation calculation, int id);

    /**
     * Удаляет расчет с заданным ID
     * @param id - id расчета, который нужно удалить
     * @return - true если расчет был удален, иначе false
     */
    boolean delete(int id);
}
