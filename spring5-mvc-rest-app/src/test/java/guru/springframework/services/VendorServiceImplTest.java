package guru.springframework.services;

import guru.springframework.api.v1.mapper.VendorMapper;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VendorServiceImplTest {
    @Mock
    VendorRepository vendorRepository;
    VendorMapper vendorMapper = VendorMapper.INSTANCE;
    VendorService vendorService;
    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(vendorMapper, vendorRepository);
    }

    @Test
    public void getAllVendors() throws Exception {
        Vendor vendor1 = new Vendor();
        vendor1.setId(1L);
        vendor1.setName("La California");

        Vendor vendor2 = new Vendor();
        vendor2.setId(2L);
        vendor2.setName("Bananera Cisneros");

        when(vendorRepository.findAll()).thenReturn(Arrays.asList(vendor1, vendor2));

        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        assertEquals(2, vendorDTOS.size());
    }

    @Test
    public void getVendorById() throws Exception {
        Vendor vendor1 = new Vendor();
        vendor1.setId(1L);
        vendor1.setName("La California");

        when(vendorRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(vendor1));

        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        assertEquals("La California", vendorDTO.getName());
    }
}
