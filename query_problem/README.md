# Cách lấy dữ liệu mã nguồn của sinh viên:
1. Sau khi thực thi tệp "1_Query_SubmitProblem_X.txt" trong MySQL sẽ được tệp "2_result_QuerySubmitProblem_X.txt"
2. Clone data từ tệp "2_result_QuerySubmitProblem_X.txt" về:
scp -P 23456 -i deploy.txt huyen@oasis.uet.vnu.edu.vn:/var/lib/mysql-files/2_result_QuerySubmitProblem_7.txt .
3. Copy "2_result_QuerySubmitProblem_X.txt" vào folder query_problem
4. Chạy code trong DataProcessing.java để được câu lệnh trong tệp "3_query_buggy_X.txt"
5. Sử dụng câu lệnh trong tệp "3_query_buggy_X.txt" chạy trong MySQL được các tệp kết quả có dạng: problem_X_student_Y.txt (trong folder mysql-files)
6. Tệp này được phân tích trong DataProcessing.java để ra kết quả cuối cùng trong detected_buggy/data_process.csv