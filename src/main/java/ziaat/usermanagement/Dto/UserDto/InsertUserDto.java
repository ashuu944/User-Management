package ziaat.usermanagement.Dto.UserDto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class InsertUserDto {
    private Long userId;
    @Column(nullable = false)
    private String fName;
    private String mName;
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;
}
