package com.generation.blogpessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoal.model.Usuario;


/*
 * informar para o Security os dados de acesso da ApI
 */
public class UserDetailsImpl implements UserDetails {
	
	// versão da classe que estamos trabalhando
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Usuario user) {
	
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// autorização de acesso do usuario
		return authorities;
	}

	@Override
	public String getPassword() {
		// retorna a senha do usuario
		return password;
	}

	@Override
	public String getUsername() {
		// retorna o usuario que esta tentando logar
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// se a conta não expirou ele tem acesso 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// se a conta não esta bloqueada 
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// se a credencial não estiver expirada
		return true;
	}

	@Override
	public boolean isEnabled() {
		// se o usuario estiver habilitado
		return true;
	}
}
