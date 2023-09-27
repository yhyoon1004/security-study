package com.example.security4.userDetails;

import com.example.security4.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;



@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    //User Entity가 가지고 있는 권한 목록 저장
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //권한 목록을 저장할 컬렉션
        Collection<GrantedAuthority> roleList = new ArrayList<>();
        //권한 설정
        roleList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE" + user.getRole();
            }
        });
        return roleList;
    }

    @Override
    public String getPassword() {
        return "{noop}" + user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정 활성화 여부
    @Override
    public boolean isEnabled() {
        return false;
    }
}
