When you run the main app, you can see the object which worker and viewmodel using is same 
<img width="1029" alt="Screenshot 2024-09-23 at 10 55 49 PM" src="https://github.com/user-attachments/assets/0729a038-a0ad-452a-a94c-594b3e58972b">

When you run the UI test, you can see the object and worker got a different instance even though it's singleton as during the tests

EarlyEntryPoints doesn't share any state with singleton and has it's own graph of objects 
https://dagger.dev/hilt/early-entry-point

<img width="1018" alt="Screenshot 2024-09-23 at 10 56 22 PM" src="https://github.com/user-attachments/assets/9db505a2-b756-48e4-a040-b14da5826a51">
