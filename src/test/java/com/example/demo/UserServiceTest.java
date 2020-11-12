package com.example.demo;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@InjectMocks
	UserService service;

	@Mock
	UserRepository repository;

	private UserRequest request;

	/*
	 * setting up user request before
	 */
	@Before
	public void setup() {

		request = new UserRequest().setFirstName("Joe").setLastName("Trader");
	}

	@Test
	public void createUser_calls_repository_save_method_with_userEntity() {

		when(repository.save(any(UserEntity.class))).thenReturn(new UserEntity().setId("id").setName("Joe Trader")
				.setOrderId(0).setTimeStamp((new Timestamp(currentTimeMillis())).toString()));

		String expectedName = "Joe Trader";
		int expectedTripId = 0;

		String userId = service.create(request);
		verify(repository).save(any(UserEntity.class));

		ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);

		verify(repository, times(1)).save(userEntityArgumentCaptor.capture());

		assertAll(() -> assertEquals(expectedName, userEntityArgumentCaptor.getValue().getName()),
				() -> assertEquals(expectedTripId, userEntityArgumentCaptor.getValue().getOrderId()));

	}

	/*
	 * As per my understanding need to write unit test when user pass request need
	 * to save data with new id i am using createUser method go generate id then
	 * asserting that expected value
	 */
	@Test
	public void whenPassing_UserRequest_createUser_Should_Return_Some_UserID() {
		// String userId = service.createUser();
		when(repository.save(any(UserEntity.class))).thenReturn(new UserEntity().setId("id").setName("Joe Trader")
				.setOrderId(1).setTimeStamp((new Timestamp(currentTimeMillis())).toString()));

		String expectedUserId = service.create(request);
		verify(repository).save(any(UserEntity.class));

		ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);

		verify(repository, times(1)).save(userEntityArgumentCaptor.capture());

		String actuaUserId = userEntityArgumentCaptor.getValue().getId();
		assertNotNull(actuaUserId);
		assertEquals(expectedUserId, actuaUserId);

	}

	/*
	 * unit test for createUser method to return UserID
	 */
	@Test
	public void createUser_Should_Return_Some_UserID() {
		
		String userId = service.createUser();

		String expectedId = "id";

		assertNotNull(userId);
		assertEquals(userId, expectedId);

	}
}
