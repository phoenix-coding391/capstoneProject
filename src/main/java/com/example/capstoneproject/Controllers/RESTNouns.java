package com.example.capstoneproject.Controllers;

/**
 * Store the API Path and REST Nouns as constants to make the REST Controllers more robust and consistent.
 */
public class RESTNouns {
    // API Versioning
    public static final String VERSION_1 = "/v1";

    // General Paths
    public static final String ID = "/{id}";

    // Specific Resources
    public static final String ADMINS = "/admin";
    public static final String AGENTS = "/agent";
    public static final String CUSTOMERS = "/customer";
    public static final String HOMES = "/home";
    public static final String POLICIES = "/policy";
    public static final String QUOTES = "/quote";
    public static final String USERS = "/user";
    public static final String VEHICLES = "/vehicle";
}
