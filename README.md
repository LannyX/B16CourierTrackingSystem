# CourierTrackingSystem

In this application, users are able to check their shipment status or request a pick up using barcode scanner or type, and search nearby location.

## Steps after launch the app
1. User can choose the country when they first launch the application
2. User need to agree to the Term and Condition
3. User Login
4. Main Screen with the buttons to navigate to each shipment status
5. Navigation drawer with buttons contains Barcode Scanner, Pickup Request, Shipment Status, Search Nearby, Settings, Contact Us, Technology used and log out.

## Functions
1. Barcode Scanner - Used Google mobile vision API to detects barcodes in real time in any orientation. It can also detect and parse several barcodes in different formats at the same time.
2. Pickup Request - Request a pickup by providing package name, using retrofit to send request and get message from server
3. Shipment Status - View shipment status by categories: all, vendor, track number, etc. using retrofit, then display data in recyclerView
4. Search Nearby Location - Used Google Map, Place API and Retrofit to locate user's current location and find the nearby Courier Service Location. 
5. Settings - Settings allow user to change the settings, the user can select country where he/she is geographically located. 
6. Contact us - User can get in touch with the customer service team either via email or phone.
