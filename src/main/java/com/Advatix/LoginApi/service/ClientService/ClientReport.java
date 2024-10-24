package com.Advatix.LoginApi.service.ClientService;

import com.Advatix.LoginApi.dao.ClientDao.ClientRepo;
import com.Advatix.LoginApi.entity.Client.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientReport {
    @Autowired
    private ClientRepo clientRepo;

    public Map<String, List<String>> getListMap(Map<Integer, String> map) {
        Map<String, List<String>> map1 = new HashMap<>();
        List<ClientEntity> listClient = clientRepo.findAll();
        List<String> ls = new ArrayList<>();
        List<String> ls1 = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals("clientId")) {
                for (ClientEntity client : listClient) {
                    ls.add(String.valueOf(client.getClientId()));
                }
                map1.put(entry.getValue(), ls);
            } else if (entry.getValue().equals("clientName")) {
                for (ClientEntity client : listClient) {
                    ls1.add(client.getClientName());
                }
                map1.put(entry.getValue(), ls1);
            }
        }
        return map1;
    }

}
