package org.aldogioia.templatesecurity.service.implementations;

import lombok.RequiredArgsConstructor;
import org.aldogioia.templatesecurity.data.dao.UserDao;
import org.aldogioia.templatesecurity.data.entities.User;
import org.aldogioia.templatesecurity.security.CustomUserDetails;
import org.aldogioia.templatesecurity.security.exception.customException.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;
    /**
     * Carica un utente in base all'email.
     *
     * @param email l'email dell'utente da caricare
     * @return i dettagli dell'utente
     * @throws UsernameNotFoundException se l'utente non viene trovato
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with phone number: " + email));
        return new CustomUserDetails(user);
    }

    /**
     * Ottiene l'email dell'utente attualmente autenticato.
     *
     * @return l'email dell'utente attualmente autenticato
     */
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
