package guru.springframework.api.v1.model;

import lombok.Data;

@Data
public class VendorDTO {
    Long id;
    String name;
    String vendor_url;
}
