#Command in git 
- git init <biến thư mực thành repo>
- git status <kiểm tra trạng thái >
- git add . <chuyển thư mục thay đổi vào kho >
- git reset <chuyển thư mục ra khỏi kho>
- git commit -m "them vao kho lan 1" <thêm ghi chú vào từng thời điểm chuyển>
- git log <xem lại từng ghi chú commit hiện checkout id>
- git log --oneline 
- git checkout checkoutid <quay lại thời điểm commit theo id>
- git checkout branchname <chuyển về hiện tại>


+ git branch <kiểm tra branch>
+ git checkout -b branchmoi <tạo branch mới>
+ git branch -d tenbranch <xóa đi branch>
+ git checkout tenbranch  <di chuyen branch>
+ git merge tenbranch <gộp branch> <nếu chỉnh sửa cùng 1 chỗ thì sẽ có conflict>
    - Xử lí conflict :  
        + B1 : xóa code conflict và lưu lại
        + B2 : git add .
        + B3 : git commit 
        + git sẽ tự động merge
+ ***C1 :***
+ git push <dường dẫn repo> master
+ ***C2 :***
+ git remote add origin <đường dẫn repo>
+ git push origin master
    - Sự khác nhau của git pull và git fetch
        + git full <cập nhật hết sự thay đổi trên repo>
        + git fetch <cập nhật xem thay đổi nhưng chỉ xem thôi>

##Clone
- Tạo branch ở local xong đẩy lên git
- B1: cd thu muc
- B2 : git clone <đường dẫn repo>
    + ls <kiem tra thu muc>
- B3 : git checkout -b <tênbranch>
- B4 : git branch
- B5 : git push -u origin <tênbranch>
- bonus git push -f origin <ten branch>  "de ghi de branch local len branch remote"
- Lấy branch có sẵn do ng khác tạo trên git
  - B1 :git fetch origin   
    - B2: git checkout -b <tên branch> origin/<tên branch>

###Tạo git ignore
- B1: tạo 1 .gitignore trong repo
- B2: Nhập tên file muốn ignore vd: index.html

###Làm việc với nhóm branch và merge
- B1 : Tạo thư mục để lưu project
- B2 : git clone "https://github.com/javier1234559/BoardGo.git"
- B3 : git checkout -b "tên branch : vd hung" "chỉ tạo nếu chưa có branch"
- B4 : git checkout "tên branch : vd hung"
- B5 : Chỉnh sửa file bình thường

###Tạo commit

- B6: git add .
- B7: git commit -m "noi dung can check point"
- B8: git push

###Hằng ngày nếu muốn cập nhật folder theo repo thì nhập 

- git pull 
- git pull origin main  "neu muon cap nhat va lam tiep theo main"




