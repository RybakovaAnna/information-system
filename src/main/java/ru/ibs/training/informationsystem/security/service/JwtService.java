package ru.ibs.training.informationsystem.security.service;

import ru.ibs.training.informationsystem.controllers.api.v1.dtos.AuthDto;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.TokenDto;

public interface JwtService {

    TokenDto authorise(AuthDto authDto);
}
