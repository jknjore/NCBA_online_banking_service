//package com.ncba.online_banking.Tests;
//
//
//import com.ncba.online_banking.Helpers.CustomerStatus;
//import com.ncba.online_banking.repositories.AccountRepository;
//import com.ncba.online_banking.repositories.CustomerRepository;
//
//public class CustomerServiceTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @Mock
//    private AccountRepository accountRepository;
//
//    @InjectMocks
//    private CustomerServiceImpl customerService;
//
//    public CustomerServiceTest() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testRegisterCustomer() {
//        CustomerDto dto = new CustomerDto();
//        dto.name = "Jonah";
//        dto.email = "jonah@example.com";
//        dto.password = "pass";
//        dto.idNumber = "12345678";
//        dto.mobileNumber = "0712345678";
//
//        Customer saved = new Customer();
//        saved.setId(1L);
//        saved.setEmail(dto.email);
//        saved.setStatus(CustomerStatus.PENDING_VERIFICATION);
//
//        when(customerRepository.save(any(Customer.class))).thenReturn(saved);
//
//        Customer result = customerService.register(dto);
//
//        assertEquals(CustomerStatus.PENDING_VERIFICATION, result.getStatus());
//        verify(customerRepository, times(1)).save(any(Customer.class));
//    }
//}
