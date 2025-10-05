package org.aldogioia.templatesecurity.configurations;

import lombok.RequiredArgsConstructor;
import org.aldogioia.templatesecurity.data.dto.UserCreateDto;
import org.aldogioia.templatesecurity.data.entities.User;
import org.aldogioia.templatesecurity.data.enumerators.Role;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configurazione per il bean {@link ModelMapper}.
 * <p>
 * Definisce e configura un'istanza di {@link ModelMapper} per la mappatura automatica tra oggetti.
 * Abilita il matching dei campi e imposta il livello di accesso ai campi pubblici.
 */
@Configuration
@RequiredArgsConstructor
public class ModelMapperConfig {
    private final PasswordEncoder passwordEncoder;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, String> passwordConverter = context -> passwordEncoder.encode(context.getSource());

        // mapping da UserCreateDto a User, crittografa la password
        modelMapper.addMappings(new PropertyMap<UserCreateDto, User>() {
            @Override
            protected void configure() {
                map().setRole(Role.ROLE_ADMIN);
                using(passwordConverter).map(source.getPassword(), destination.getPassword());
            }
        });

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PUBLIC);

        return modelMapper;
    }
}
