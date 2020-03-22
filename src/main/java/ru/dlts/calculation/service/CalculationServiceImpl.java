package ru.dlts.calculation.service;

import org.springframework.stereotype.Service;
import ru.dlts.calculation.model.Calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CalculationServiceImpl implements CalculationService {
    // Хранилище клиентов
    private static final Map<Integer, Calculation> CALCULATION_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID расчета
    private static final AtomicInteger CALCULATION_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Calculation client) {
        final int clientId = CALCULATION_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CALCULATION_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<Calculation> readAll() {
        return new ArrayList<>(CALCULATION_REPOSITORY_MAP.values());
    }

    @Override
    public Calculation read(int id) {
        return CALCULATION_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Calculation client, int id) {
        if (CALCULATION_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CALCULATION_REPOSITORY_MAP.put(id, client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return CALCULATION_REPOSITORY_MAP.remove(id) != null;
    }

}
