This code implements a library management system as given in the question. 
The code assumes a unique ID for each book and a unique phone number for each member 
(however members are also assigned unique IDs). The current time is calculated through the System.currentTimeMillis command
in many places in the code in a 'double' type variable called currenttime. Also, the currenttime is not calculated again and 
again in loops, it is only calculated once each time when a command that requires it is called (for example when returning a book,
it will be called first, when the librarian prints information of all members then currenttime will be calculated once first etc).
Also, when a librarian is viewing members list, the fine is a constant and not a growing value calculated on the basis of time
when the function was called. Also, fines are assigned to members only when they return the book. Also, when issuing a book, IT IS
POSSIBLE THAT A USER MAY GET THE OPTION TO INPUT USERID TO ISSUE ONE MORE BOOK EVEN IF HIS CURRENTTIME-ISSUETIME OF PREVIOUS BOOK
IS GREATER THAN 10, BUT AS SOON AS THE USER INPUTS THE USERID HE WILL GET ERROR TO FIRST RETURN AND PAY FINE FOR THE PREVIOUS BOOK.
The code has a considerable amount of exception-handling built into it, however it assumes that the user will not put random 
strings in the phone number field (the code will still work regardless).

The entire project folder created in intelliJ has been attached.
