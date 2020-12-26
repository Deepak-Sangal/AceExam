package com.acexams.aceexam.retrofit;


import com.acexams.aceexam.activity.modal.QBankResponse;

import java.util.ArrayList;

/**
 * Created by chetan on 05/04/2020.
 */

public class Constants {


	public static final String BaseUrlNewlive  ="https://www.acexam.com/web/api/student/";
	public static final String paytmBaseUrlNewlive  ="https://www.acexam.com/web/paytm/";
	public static final String imageBaseUrlNewlive  ="https://www.acexam.com/web/public/uploads/";
	public static final String imageBaseteacher  ="https://www.acexam.com/web/public/uploads/teachers/";
	public static final String BaseImage = "https://13.234.42.204:3013/";
	public static String text="";
	public static ArrayList<QBankResponse.Data.Topic>  list  = new ArrayList();


    public static final int NETWORK_ERROR_400 = 400;
    public static final int NETWORK_ERROR_401 = 401;
    public static final int NETWORK_ERROR_403 = 403;
    public static final int NETWORK_ERROR_404 = 404;
    public static final int NETWORK_ERROR_405 = 405;
    public static final int NETWORK_ERROR_406 = 406;
    public static final int NETWORK_ERROR_407 = 407;
    public static final int NETWORK_ERROR_408 = 408;
    public static final int NETWORK_ERROR_500 = 500;
    public static final int NETWORK_ERROR_501 = 501;
    public static final int NETWORK_ERROR_502 = 502;
    public static final int NETWORK_ERROR_503 = 503;
    public static final int NETWORK_ERROR_504 = 504;
    public static final int NETWORK_ERROR_422 = 422;
    public static final String TITLE_MESSAGE = "Message";




}



