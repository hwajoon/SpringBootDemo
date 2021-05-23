package com.peter.demoprj.domain;

import lombok.*;

@Data  // Lombok
@ToString(exclude={"phone"})  // id, name, phone, address 중 phone은 보안상 정보가 올라가지 않게 제외시킴
@AllArgsConstructor
@Getter
@Setter
public class UserProfile {
    public String id;
    public String name;
    public String phone;
    public String address;
}
