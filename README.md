# BookStore

Một ứng dụng REST của một cửa hàng sách bán sách trực tuyến, giao sách đến tận nhà người mua.

Chúng ta có đối tượng chính là Book

```java
public class Book {
  private String id;
  private String title;
  private String author;
}
```

Quản lý sách trong kho. Bản ghi ứng với mỗi `bookId` có `id` cao nhất (hoặc `updateDate` gần nhất) phản ánh số lượng sách thực sự trong kho
```java
public class BookInventory{
  private int id; //số tự động tăng
  private String bookId;
  private int amount; //số sách còn lại trong kho 
  private LocalDateTime updateDate; //ngày, giờ cập nhật lại
}
```

**Một số REST API:**

1. Sinh ra 1000 đầu sách sử dụng [Java Faker](https://www.baeldung.com/java-faker). Ban đâu khi sinh ngẫu nhiên hãy tạo cả BookInventory với amount ngẫu nhiên từ 0 đến 100 quyển sách.
   Phương thức: [POST] http://localhost:8082/v1/books/create
   Phương thức: [POST] http://localhost:8082/v1/book-inventories/create

2. Liệt kê các đầu sách sắp xếp theo tiêu chí title từ A-Z
   Phương thức: [GET] http://localhost:8082/v1/books

3. Tìm đầu sách có title chứa keyword nào đó
   Ví dụ, cần tìm đầu sách có title chứa "Things"
   Phương thức: [GET] http://localhost:8082/v1/books/title-contain-Things

4. Liệt kê các đầu sách hiện đang hết amount = 0;
   Phương thức: [GET] http://localhost:8082/v1/book-inventories/out-of-stock


5. Giả lập lệnh mua sách buy_book, mặc định số lượng mua là 1 quyển, nhưng có thể mua nhiều hơn 1 quyển.
6. Nếu số lượng mua lớn số lượng sách có trong kho hãy tạo một event để đặt hàng thêm sách nhập về kho.
7. Hãy tạo một schedule routine cứ 1 phút chạy 1 lần để tìm ra các đầu sách chỉ còn 1 quyển trong kho để tiến hàng nhập hàng bổ xung, số lượng là 5 quyển mỗi lần bổ xung.
8. Dùng Spring Boot AOP để viết một advice ứng với annotation @Benchmark để đo đạc thời gian thực thi các lệnh REST
