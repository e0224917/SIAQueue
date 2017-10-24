package com.flymetothemoon.siaqueue.retrofit;


import com.flymetothemoon.siaqueue.retrofit.model.FTResponse;
import com.flymetothemoon.siaqueue.retrofit.model.GetPassenger;
import com.flymetothemoon.siaqueue.retrofit.model.PassengerRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by nhatton on 10/23/17.
 */

public interface SIAService {
    @Headers("x-api-key: du1yO8KLZm9PfFeg6OHQW8CFcpK1RMym3JXp78Uk")
    @POST("checkin/getpassenger")
    Call<FTResponse<GetPassenger>> getPassenger(@Body PassengerRequest request);
}
