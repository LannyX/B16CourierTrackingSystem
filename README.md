# CourierTrackingSystem

In this application, users are able to check their shipment status or request a pick up using barcode scanner or type, and search nearby  courier servcie locations.


## Launching the app

1. User can choose the country via search when they first launch the application.

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.23.16%20PM.png)

2. User need to agree to the Term and Condition for the first time.

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.23.36%20PM.png)

3. User Login.

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.23.49%20PM.png)

4. Main Screen with the buttons to navigate to each shipment status.

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.24.16%20PM.png)

5. Navigation drawer with buttons contains Barcode Scanner, Pickup Request, Shipment Status, Search Nearby, Settings, Contact Us, Technology used and log out.

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.24.29%20PM.png)

## Functions
1. Barcode Scanner - Uses Google mobile vision API to detects barcodes in real time in any orientation. It can also detect and parse several barcodes in different formats at the same time.

2. Pickup Request - Request a pickup by providing package name, using retrofit to send request and get message from server.

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.24.49%20PM.png)

3. Shipment Status - View shipment status by categories: all, vendor, track number, etc. using retrofit, then display data in recyclerView.

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.26.29%20PM.png)
![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.26.51%20PM.png)

4. Search Nearby Location - Uses Google Map, Place API and Retrofit to fetch data to show user's current location and find the nearby Courier Service Location, also uses recyclerView to show them in a list. 

![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.27.52%20PM.png)
![image](https://github.com/LannyX/B16CourierTrackingSystem/blob/master/screenshot/Screen%20Shot%202019-01-29%20at%201.28.06%20PM.png)

5. Settings - Settings allows user to change the settings, the users can select country where he/she is geographically located in shared prefrence. 

6. Contact us - User can get in touch with the customer service team either via email or phone.


License
=======
See LICENSE.md


Credits
=================
Developers:
Muhammad Omer
Phat Nguyen
Lanny Xu

