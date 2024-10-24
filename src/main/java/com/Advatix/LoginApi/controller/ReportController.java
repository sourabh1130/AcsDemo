package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.service.ClientService.ClientReport;
import com.Advatix.LoginApi.service.UserService.UserReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ClientReport clientReport;

    @Autowired
    private UserReport userReport;

    // Endpoint to retrieve the list of clients based on input map

    @GetMapping("/clients/list")
    public Map<String, List<String>> getClientListMap(@RequestBody Map<Integer, String> inputMap) {
        return clientReport.getListMap(inputMap);
    }

    // Endpoint to retrieve the list of users based on input map

    @GetMapping("/users/list")
    public Map<String, List<String>> getUserListMap(@RequestBody Map<Integer, String> inputMap) {
        return userReport.getListMap(inputMap);
    }

    // Endpoint to retrieve both user and client data
    @PostMapping("/combined/list")
    public Map<String, Map<String, List<String>>> getCombinedListMap(@RequestBody Map<String, Map<Integer, String>> inputMaps) {
        // Extract client and user maps from the input
        Map<Integer, String> clientMap = inputMaps.get("clients");
        Map<Integer, String> userMap = inputMaps.get("users");

        // Retrieve data from both services
        Map<String, List<String>> clientData = clientReport.getListMap(clientMap);
        Map<String, List<String>> userData = userReport.getListMap(userMap);

        // Combine the results
        Map<String, Map<String, List<String>>> combinedData = Map.of(
                "clients", clientData,
                "users", userData
        );

        return combinedData;
    }
}
