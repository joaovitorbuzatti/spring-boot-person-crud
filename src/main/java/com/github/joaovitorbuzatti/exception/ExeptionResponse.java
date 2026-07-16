package com.github.joaovitorbuzatti.exception;

import java.util.Date;

public record ExeptionResponse(Date timestamp, String message, String details) {}
