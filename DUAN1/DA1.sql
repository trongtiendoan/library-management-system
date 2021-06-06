CREATE DATABASE QLTV_Project1
GO
USE QLTV_Project1
GO

-- BẢNG NGƯỜI DÙNG
CREATE TABLE NGUOIDUNG
(
	MaND nvarchar(10) primary key,
	Password nvarchar(50) not null,
	HoTen nvarchar(100) not null,
	VaiTro bit not null
)
GO
-- BẢNG SINH VIÊN
CREATE TABLE SINHVIEN
(
	MaSV nvarchar(7) primary key,
	HoTen nvarchar(100) not null,
	GioiTinh bit not null,
	DiaChi nvarchar(255) not null,
	SDT nvarchar(12) not null,
	Email nvarchar(100) not null
)
GO
-- BẢNG LOẠI SÁCH
CREATE TABLE LOAISACH
(
	MaLoai int identity(1,1) primary key,
	TenLoai nvarchar(50) not null,
	Vitri nvarchar(50) not null
)
GO
-- BẢNG TÁC GIẢ
CREATE TABLE TACGIA
(
	MaTG int identity(1,1) primary key,
	TenTG nvarchar(50) not null,
	GhiChu nvarchar(500) not null,
	Hinh nvarchar(50) not null
)
GO
-- BẢNG NXB
CREATE TABLE NHAXUATBAN
(
	MaNXB int identity(1,1) primary key,
	TenNXB nvarchar(50) not null,
	DiaChi nvarchar(255) not null,
	Email nvarchar(100) not null
)
GO
-- BẢNG SÁCH
CREATE TABLE SACH
(
	MaSach int identity(1,1) primary key,
	TenSach nvarchar(50) not null,
	MaLoai int not null,
	MaNXB int not null,
	MaTG int not null,
	SoLuong int not null,
	NoiDung nvarchar(500) not null,
	Hinh nvarchar(50) not null
	FOREIGN KEY (MaLoai) REFERENCES LOAISACH (MaLoai) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaTG) REFERENCES TACGIA (MaTG) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaNXB) REFERENCES NHAXUATBAN (MaNXB) ON DELETE NO ACTION ON UPDATE CASCADE
)
GO
-- BẢNG PHIEUMUON
CREATE TABLE PHIEUMUON
(
	MaPM int identity(1,1) primary key,
	MaSV nvarchar(7) not null,
	NgayMuon date not null,
	NgayTra date not null,
	MaND nvarchar(10) not null,
	TrangThai nvarchar(20) not null,
	GhiChu nvarchar(255) not null,
	FOREIGN KEY (MaSV) REFERENCES SINHVIEN(MaSV) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND) ON DELETE NO ACTION ON UPDATE CASCADE,
)
GO
-- BẢNG CTPM 
CREATE TABLE CHITIETPM
(
	MaPM int not null,
	MaSach int not null,
	TrangThai nvarchar(20) not null,
	SoLuong int not null,
	GhiChu nvarchar(255) not null,
	primary key (MaSach,MaPM),
	FOREIGN KEY (MaSach) REFERENCES SACH(MaSach) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaPM) REFERENCES PHIEUMUON(MaPM) ON DELETE NO ACTION ON UPDATE CASCADE
)
GO

-- Insert bảng NGUOIDUNG
INSERT NGUOIDUNG (MaND, Password, HoTen, VaiTro) VALUES 
	(N'ThongHH', N'songlong', N'Hồ Huỳnh Thông', 1),
	(N'BaoBD', N'songlong', N'Bùi Duy Bảo', 1),
	(N'PhucTM', N'songlong', N'Trần Minh Phúc', 1),
	(N'TienDT', N'123456', N'Đoàn Trọng Tiến', 1),
	(N'CanhNV', N'123456', N'Nguyễn Văn Cảnh', 1),
	(N'TeoNV', N'songlong', N'Nguyễn Văn Tèo', 0),
	(N'ThaoLTH', N'songlong', N'Lê Thị Hương Thảo', 0)
GO
---- Insert bảng SINHVIEN
INSERT SINHVIEN (MaSV, HoTen, GioiTinh, SDT, Email, DiaChi) VALUES
	(N'PS12345', N'LỮ HUY CƯỜNG', 0, N'0967432689', N'cuonghc@gmail.com', N'TKTQ Q.Bình Tân'),
	(N'PS12654', N'NGUYỄN CAO PHƯỚC', 1, N'0123454656', N'phuocnc@gmail.com', N'Q.12'),
	(N'PS03596', N'NGUYỄN THANH HIỀN', 0, N'0924696779','hiennt@gmail.com', N'Bình Dương'),
	(N'PS03603', N'LÊ PHẠM KIM THANH', 0, N'0924696779', N'PS03603@fpt.edu.vn', N'Q.10'),
	(N'PS03610', N'TRẦN ĐÌNH TRƯỜNG', 1, N'0941528106', N'PS03610@fpt.edu.vn', N'Q.1'),
	(N'PS03614', N'NGUYỄN VĂN SÁU', 1, N'0940711328', N'PS03614@fpt.edu.vn', N'Q.2'),
	(N'PS03618', N'PHÍ ĐÌNH VIỆT HÙNG', 1, N'0939020097', N'PS03618@fpt.edu.vn', N'Q.3'),
	(N'PS03638', N'PHẠM NHẬT MINH', 1, N'0927771672', N'PS03638@fpt.edu.vn', N'Q.4'),
	(N'PS03640', N'LƯU THANH NGỌC', 0, N'0918358164', N'PS03640@fpt.edu.vn', N'Q.5'),
	(N'PS03662', N'NGUYỄN CAO NGỌC LỢI', 1, N'0930260679', N'PS03662@fpt.edu.vn', N'Q.6'),
	(N'PS03674', N'TRẦN TUẤN ANH', 1, N'0914082094', N'PS03674@fpt.edu.vn', N'Q.7'),

	(N'PS02979', N'ĐOÀN TRẦN NHẬT VŨ',1, N'0912374818', N'PS02979@fpt.edu.vn',N'Bình Dương'),
	(N'PS02983', N'NGUYỄN HOÀNG THIÊN PHƯỚC',1, N'0912499836', N'PS02983@fpt.edu.vn',N'Q.7'),
	(N'PS02988', N'HỒ HỮU HẬU',1, N'0924984876', N'PS02988@fpt.edu.vn', N'Q.8'),
	(N'PS03031', N'PHAN TẤN VIỆT',1, N'0924832716', N'PS03031@fpt.edu.vn',N'Q.9'),
	(N'PS03046', N'NGUYỄN CAO PHƯỚC',1, N'0977117727', N'PS03046@fpt.edu.vn',N'Q.10'),
	(N'PS03080', N'HUỲNH THANH HUY', 1, N'0916436052', N'PS03080@fpt.edu.vn',N'Q.11'),
	(N'PS03088', N'NGUYỄN HOÀNG TRUNG',1, N'0938101529', N'PS03088@fpt.edu.vn',N'Q.12'),
	(N'PS03096', N'ĐOÀN HỮU KHANG',1, N'0945196719', N'PS03096@fpt.edu.vn',N'Q.1'),
	(N'PS03104', N'LÊ THÀNH PHƯƠNG',0, N'0922948096', N'PS03104@fpt.edu.vn',N'Q.2'),
	(N'PS03120', N'PHẠM NGỌC NHẬT TRƯỜNG',1, N'0994296169', N'PS03120@fpt.edu.vn',N'Q.3'),
	(N'PS03130', N'ĐẶNG BẢO VIỆT',1, N'0917749344', N'PS03130@fpt.edu.vn',N'Q.4'),
	(N'PS03134', N'LÊ DUY BẢO',1, N'0926714368', N'PS03134@fpt.edu.vn',N'Q.5'),
	(N'PS03172', N'NGUYỄN ANH TUẤN', 1, N'0920020472', N'PS03172@fpt.edu.vn',N'Q.6'),
	(N'PS03202', N'PHAN QUỐC QUI',1, N'0930649274', N'PS03202@fpt.edu.vn',N'Q.7'),
	(N'PS03203', N'ĐẶNG LÊ QUANG VINH',1, N'0920197355', N'PS03203@fpt.edu.vn',N'Q.8'),
	(N'PS03205', N'NGUYỄN MINH SANG',1, N'0967006218', N'PS03205@fpt.edu.vn',N'Q.9'),
	(N'PS03222', N'TRẦM MINH MẪN',1, N'0911183649', N'PS03222@fpt.edu.vn',N'Q.10'),
	(N'PS03230', N'NGUYỄN PHẠM MINH HÂN',1, N'0983469892', N'PS03230@fpt.edu.vn',N'Q.11'),
	(N'PS03233', N'LƯU KIM HOÀNG DUY',1, N'0938357735', N'PS03233@fpt.edu.vn',N'Q.12'),
	(N'PS03251', N'TRẦN QUANG VŨ',1, N'0914531913', N'PS03251@fpt.edu.vn',N'Bình Tân')
GO


-- Insert bảng NHAXUATBAN
SET IDENTITY_INSERT NHAXUATBAN ON
GO
INSERT NHAXUATBAN (MaNXB, TenNXB, DiaChi, Email) VALUES 
	(1, N'Nhà xuất bản Kim Đồng', N'55 Quang Trung, Hai Bà Trưng, Hà Nội', N'kimdong@hn.vnn.vn'),
	(2, N'Nhà xuất bản Trẻ', N'161B Lý Chính Thắng, Phường 7, Quận 3, Thành phố Hồ Chí Minh', N'hopthubandoc@nxbtre.com.vn'),
	(3, N'Nhà xuất bản Văn học', N'18 Nguyễn Trường Tộ, Trúc Bạch, Ba Đình, Hà Nội', N'info@nxbvanhoc.com.vn'),
	(4, N'Nhà Xuất Bản Hà Nội', N'số 4 Tống Duy Tân, Hàng Bông, Hoàn Kiếm, Hà Nội', N'vanthu_nxbhn@hanoi.gov.vn'),
	(5, N'Nhà xuất bản Thế Giới', N'46 Trần Hưng Đạo, Hà Nội', N'thegioi@hn.vnn.vn'),
	(6, N'Nhà xuất bản Tổng hợp thành phố Hồ Chí Minh', N'62 Nguyễn Thị Minh Khai, Phường Đa Kao, Quận 1, TP.HCM', N'tonghop@nxbhcm.com.vn'),
	(7, N'Nhà xuất bản Hồng Đức', N'Số 65, phố Tràng Thi, Phường Hàng Bông, Quận Hoàn Kiếm, Hà Nội', N''),
	(8,N'NXB Phụ Nữ',N'39 Hàng Chuối, Phạm Đình Hổ, Hai Bà Trưng, Hà Nội',N'www.nxbphunu.com.vn'),
	(9,N'Nhà Xuất Bản Văn Hoá Thông Tin',N'7 Nguyễn Thị Minh Khai, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh',N'')
GO
SET IDENTITY_INSERT NHAXUATBAN OFF
GO
-- Insert bảng TACGIA
SET IDENTITY_INSERT TACGIA ON
GO
INSERT TACGIA (MaTG, TenTG, GhiChu, Hinh) VALUES 
	(1, N'Gilbert Delahaye', N'Gilbert Delahaye chào đời tại tại Franqueville-Saint-Pierre, Pháp ngày 19 tháng 3 năm 1923, qua đời ngày 06 tháng 12 năm 1997. Ông là một tác giả sách thiếu nhi người Bỉ, được biết đến nhiều nhất với bộ sách Cô Bé Mác-tin mà ông hợp tác cùng họa sĩ Marcel Marlier', N'gilbert_delahaye.jpeg'),
	(2, N'Nguyễn Nhật Ánh', N'Nguyễn Nhật Ánh sinh ngày 7 tháng 5 năm 1955 tại tỉnh Quảng Nam.  Ông được coi là một trong những nhà văn thành công nhất viết sách cho tuổi thơ, tuồi mới lớn với hơn 100 tác phẩm các thể loại.', N'NguyenNhatAnh.jpg'),
	(3, N'Nam Cao', N'Nam Cao (1915 hoặc 1917 – 28 tháng 11 năm 1951) là một nhà văn và cũng là một chiến sĩ, liệt sĩ người Việt Nam. Ông là nhà văn hiện thực lớn (trước Cách mạng), một nhà báo kháng chiến (sau Cách mạng), một trong những nhà văn tiêu biểu nhất thế kỷ 20. Nam Cao có nhiều đóng góp quan trọng đối với việc hoàn thiện phong cách truyện ngắn và tiểu thuyết Việt Nam ở nửa đầu thế kỷ 20', N'NamCao.jpg'),
	(4, N'Ernest Hemingway', N'Ernest Miller Hemingway (21 tháng 7 năm 1899 – 2 tháng 7 năm 1961; phát âm tiếng Việt: Ơ-nít Mi-lơ Hê-minh-uê) là một tiểu thuyết gia người Mỹ, nhà văn viết truyện ngắn và là một nhà báo', N'ErnestHemingway.jpg'),
	(5, N'N. Gregory Mankiw', N'Nicolas Gregory Mankiw (1958-) là một nhà kinh tế học người Mỹ. Ông được bình chọn là một trong 20 nhà kinh tế học xuất sắc nhất thế giới hiện nay. Chuyên ngành chính của ông là kinh tế học vĩ mô. Ông là một trong những đại biểu của trường phái Kinh tế học Keynes mới', N'NGregoryMankiw.jpg'),
	(6, N'Roger Stone', N'Roger Jason Stone Jr. (sinh ngày 27 tháng 8 năm 1952) là một tội phạm liên bang, nhà tư vấn chính trị người Mỹ, tác giả, nhà vận động hành lang và chiến lược gia nổi tiếng với việc sử dụng nghiên cứu đối lập, thường dành cho các ứng cử viên của Đảng Cộng hòa', N'RogerStone.png'),
	(7, N'Nguyễn Ngọc Thạch', N'Nguyễn Ngọc Thạch (bút danh khác: Jade), là tác giả trẻ được cộng đồng mạng quan tâm khi chọn những mảng đề tài gai góc, gây nhiều tranh cãi trong xã hội như đồng tính, mại dâm, chuyển giới', N'NguyenNgocThach.jpg'),
	(8, N'Adam Khoo',N'Adam Khoo Yean Ann sinh ngày 8 tháng 4 năm 1974, là một doanh nhân thành đạt, tác giả của những quyển sách bán chạy nhất và cũng là chuyên gia đào tạo hàng đầu',N'Adam.jpg'),
	(9, N'Dale Carnegie',N'Dale Carnegie là một nhà văn và giảng viên người Mỹ, đồng thời là người phát triển các khóa học về cải thiện bản thân, kỹ năng bán hàng, đào tạo doanh nghiệp,...',N'dale.jpg'),
	(10, N'Fujiko Fujio',N'Fujiko Fujio khi tên ông có hai chữ Fu IPA: là bút danh chung của hai nghệ sĩ manga Nhật Bản, một số người Việt gọi là Ông Hai Phú',N'fujio.jpg'),
	(11, N'Dostoevsky',N'Fyodor Mikhailovich Dostoevsky, đôi khi được phiên âm là Dostoyevsky, là một tiểu thuyết gia, nhà triết học, nhà văn viết truyện ngắn, nhà tiểu luận và nhà báo người Nga',N'dostoevsky.jpg'),
	(12, N'Paulo Coelho',N'Paulo Coelho de Souza là nhà văn và tiểu thuyết gia người Brazil, nổi tiếng với tiểu thuyết Nhà giả kim.',N'paulo.jpg'),
	(13, N'J.D.Salinger',N'Jerome David Salinger là nhà văn Mỹ nổi tiếng với cuốn tiểu thuyết The Catcher in the Rye. Salinger đã xuất bản một số truyện ngắn trên tạp chí Story vào đầu những năm 1940',N'jd.jpg'),
	(14, N'Minh DeltaViet',N'CEO và đồng sáng lập DeltaViet Education. Anh từng đoạt giải nhất cuộc thi Khởi sự doanh nghiệp công nghệ',N'minh.jpg')
GO
SET IDENTITY_INSERT TACGIA OFF
GO
-- Insert bảng LOAISACH
SET IDENTITY_INSERT LOAISACH ON
GO
INSERT LOAISACH (MaLoai, TenLoai, ViTri) VALUES
	(1, N'Chính trị – pháp luật', N'Kệ 1'),
	(2, N'Truyện tranh', N'Kệ 2'),
	(3, N'Giáo trình', N'Kệ 3'),
	(4, N'Truyện ngắn', N'Kệ 4'),
	(5,N'Tâm lý - Kĩ năng sống',N'Kệ 2'),
	(6,N'Tiểu thuyết,Tiểu thuyết phiêu lưu',N'Kệ 4'),
	(7,N'Hư cấu kỳ ảo',N'Kệ 1')
GO
SET IDENTITY_INSERT LOAISACH OFF
go
-- Insert bảng LOAISACH
SET IDENTITY_INSERT SACH ON
GO
INSERT SACH (MaSach, TenSach, MaLoai, MaNXB, MaTG, SoLuong, NoiDung, Hinh) VALUES
	(1, N'Thất Tình Không Sao', 4, 4, 7, 15, N'“Thất nghiệp mới chết, thất tình không sao. Mất tiền mới chết, mất bồ không sao…” “…chia tay có thể đau khổ trong một thoáng, nhưng chắc chắn về lâu dài sẽ nhận ra, thất tình vốn dĩ cũng không sao.” “…ngoài kia còn nhiều điều tốt đẹp, vì hãy coi việc chia tay một người không xứng đáng là tự cho bản thân mình cơ hội để đến với những điều tốt đẹp hơn, nên thất tình cũng không sao.”', N'ThatTinhKhongSao.jpg'),
	(2, N'Tôi thấy hoa vàng trên cỏ xanh', 4, 2, 2, 24, N'Những câu chuyện nhỏ xảy ra ở một ngôi làng nhỏ: chuyện người, chuyện cóc, chuyện ma, chuyện công chúa và hoàng tử , rồi chuyện đói ăn, cháy nhà, lụt lội,... Bối cảnh là trường học, nhà trong xóm, bãi tha ma. Dẫn chuyện là cậu bé 15 tuổi tên Thiều. Thiều có chú ruột là chú Đàn, có bạn thân là cô bé Mận. Nhưng nhân vật đáng yêu nhất lại là Tường, em trai Thiều, một cậu bé học không giỏi. Thiều, Tường và những đứa trẻ sống trong cùng một làng, học cùng một trường, có biết bao chuyện chung.', N'ToiThayHoaVangTrenCoXanh.jpg'),
	(3, N'Chí Phèo', 4, 3, 3, 32, N'Chí Phèo – Với những tình tiết hấp hẫn Nam Cao đã đưa người đọc tái hiện bức tranh chân thực nông thôn Việt Nam trước 1945, nghèo đói, xơ xác trên con đường phá sản, bần cùng, hết sức thê thảm, người nông dân bị đẩy vào con đường tha hóa, lưu manh hóa.', N'ChiPheo.jpg'),
	(4, N'Cô bé Mac-tin ở trường học', 2, 1, 1, 10, N'Một trong những niềm vui ở trường là khi lớp có bạn mới chuyển đến. Hôm nay, lớp của Mác-tin có một bạn mới, bạn tên là Xanh-ti-a, đến từ đất nước Ấn Độ xa xôi. Mác-tin đã nhanh chóng làm quen với Xanh-ti-a. Các bạn đã có những giờ học cực kì thú vị ở trường. Nào kể chuyện, vẽ tranh, ra bờ sông quan sát các loại động vật dưới nước… Đi học mới thích làm sao!', N'CoBeMacTinOTruongHoc.jpg'),
	(5, N'Ông già và biển cả', 4, 6, 4, 20, N'Sức hấp dẫn, lôi cuốn của tác phẩm được tập trung chủ yếu ở chỗ: sự nhẫn nại, bền chí và ý thức vươn lên hoàn cảnh của nhân vật. Từ những chi tiết nhỏ nhặt nhất như mũi lao bị gãy, cái chày bị ngoạm đi, bàn tay bị chuột rút… đến việc ông lão cố nuốt miếng cá tanh ngòm, chắt chiu từng ngụm nước, để dành sức khỏe chinh phục con cá và chiến đấu với bầy cá mập… ', N'OngGiaVaBienCa.jpg'),
	(6, N'Đường Đến Nhà Trắng 2016', 1, 5, 6, 14, N'Cuốn sách là lời giải thích rành mạch về cách mà "đa số thầm lặng" đã chuyển phiếu bầu sang cho Donald Trump ở Pennsylvania, Wisconsin và Michigan, để trao cho ông chức Tổng thống. Stone đưa ra thông tin nội bộ về Julian Assange, Wikileaks, chủ tịch chiến dịch của Clinton, John Podesta, Huma Abedin, Anthony Weiner, Carlos Danger, Doug Band, Jeffery Epstein, và những nỗ lực để che giấu tình trạng sức khoẻ và các vấn đề sức khoẻ của Hillary.', N'DuongDenNhaTrang2016.jpg'),
	(7, N'Kinh Tế Học Vĩ Mô', 3, 7, 5, 7, N'Đây là lần đầu tiên cuốn sách kinh tế học của tác giả N.Gregory Mankiw được dịch sang Tiếng Việt và phát hành tại Việt Nam. Về nội dung 2 cuốn sách, với các khái niệm phổ biến và khái quát nhất về kinh tế vi mô và vĩ mô cũng như những giải thích về các cơ chế hoạt động của nền kinh tế.', N'KinhTeHocViMo.jpg'),
	(8, N'Tôi tài giỏi, bạn cũng thế',5,8,8,10,N'Nội dung của cuốn sách là những chia sẻ về các câu chuyện cũng như phương pháp học tập. Do chính tác giả đã trải nghiệm khi mới ở độ tuổi cấp 2, ....',N'sach8.jpg'),
	(9, N'Đắc nhân tâm',5,6,9,5,N'Sách có nội dung đưa ra những lời khuyên rất bổ ích trong cách ứng xử. Cách đối nhân xử thế trong cuộc sống hàng ngày giúp cho người đọc hoàn thiện và vươn tới thành công',N'dacnhantam.jpg'),
	(10, N'Lão Hạc',4,3,3,10,N'Lão Hạc trong truyện là một người nông dân nghèo nhưng hiền lành và lương thiện. Qua tác phẩm, người đọc hiểu được tình cảnh nghèo khổ, bế tắc của người nông dân trong xã hội thực dân nửa phong kiến.',N'laohac.jpg'),
	(11, N'Doraemon',2,1,10,20,N'Doraemon là nhân vật chính hư cấu trong loạt Manga cùng tên của họa sĩ Fujiko F. Fujio. Trong truyện lấy bối cảnh ở thế kỷ 20,',N'doremon.jpg'),
	(12, N'Tội ác và trừng phạt',6,3,11,10,N'Đây là cuốn sách từng được bình chọn là cuốn sách vĩ đại nhất mọi thời đại, một trong những cuốn sách hay nên đọc. Tội ác và trừng trị có nội dung nói về luật nhân quả trong cuộc sống là một kiệt tác về tình yêu thương giữa con người với nhau',N'toiac.jpg'),
	(13, N'Nhà giả kim',7,3,12,7,N'Nhà giả kim như là đang tự thuật trò chuyện với chính bản thân mình. Sách đã chỉ ra được những thứ đơn giản mà sâu sắc nhất trong đời, khi đọc sách mới có thể ngộ ra được. Bởi rất ít ai có thể tự mình nhận ra được điều đó',N'nhagiakiem.jpg'),
	(14, N'Bắt trẻ đồng xanh',6,3,13,5,N'Đây là một cuốn sách nhỏ xinh và mỏng không giống như những cuốn sách dày dặn với nhiều chương hồi khác. Tác phẩm đã đem đến cho độc giả cái nhìn thông qua suy nghĩ của một chàng trai trẻ nhìn về cuộc sống một cách hài hước và vô cùng thông minh.',N'batbe.jpg'),
	(15, N'Cứ đi rồi sẽ đến',6,9,14,8,N'Một trong số những cuốn sách hay mà khi đọc bạn sẽ cảm nhận được sức trẻ nhiệt huyết và cả đam mê của tác giả Minh DeltaViet. Cuốn sách rất dễ đọc bởi nó không phải suy tư nhiều',N'cudi.jpg')
GO
SET IDENTITY_INSERT SACH OFF
GO

-- Insert bảng PHIEUMUON
SET IDENTITY_INSERT PHIEUMUON ON
GO
INSERT PHIEUMUON (MaPM, MaSV, NgayMuon, NgayTra, MaND, TrangThai, GhiChu) VALUES
	(1, N'PS12345', '2020-12-01', '2020-12-15', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(2, N'PS12654', '2020-11-01', '2020-11-12', N'BaoBD', N'Đã trả', N'Đã trả'),
	(3, N'PS02979', '2020-01-02', '2020-01-16', N'BaoBD', N'Đã trả', N'Quá hạn'),
	(4, N'PS02983', '2020-02-09', '2020-02-18', N'BaoBD', N'Đã trả', N'Đã trả'),
	(5, N'PS02988', '2020-03-13', '2020-03-28', N'BaoBD', N'Đã trả ', N'Quá hạn'),
	(6, N'PS03031', '2020-04-01', '2020-04-12', N'BaoBD', N'Đã trả', N'Quá hạn'),
	(7, N'PS03046', '2020-05-05', '2020-05-20', N'BaoBD', N'Đã trả', N'Đã trả'),
	(8, N'PS03080', '2020-06-03', '2020-06-14', N'BaoBD', N'Đã trả', N'Đã trả'),
	(9, N'PS03088', '2020-07-01', '2020-07-15', N'BaoBD', N'Đã trả', N'Đã trả'),
	(10, N'PS03096', '2020-08-23', '2020-09-10', N'BaoBD', N'Đã trả', N'Đã trả'),
	(11, N'PS03104', '2020-09-06', '2020-09-20', N'BaoBD', N'Đã trả', N'Đã trả'),
	(12, N'PS03120', '2020-10-10', '2020-10-25', N'BaoBD', N'Đã trả', N'Quá hạn'),
	(13, N'PS03130', '2020-11-26', '2020-11-14', N'BaoBD', N'Chưa trả', N'Quá hạn'),
	(14, N'PS03134', '2020-11-28', '2020-12-14', N'BaoBD', N'Đã trả', N'Đã trả'),
	(15, N'PS03172', '2020-01-01', '2020-01-15', N'BaoBD', N'Đã trả', N'Đã trả'),
	(16, N'PS03202', '2020-02-01', '2020-02-14', N'BaoBD', N'Đã trả', N'Đã trả'),
	(17, N'PS03203', '2020-03-12', '2020-03-24', N'BaoBD', N'Đã trả', N'Đã trả'),
	(18, N'PS03205', '2020-04-04', '2020-04-17', N'BaoBD', N'Đã trả', N'Đã trả'),
	(19, N'PS03222', '2020-05-01', '2020-05-15', N'BaoBD', N'Đã trả', N'Quá hạn'),
	(20, N'PS03230', '2020-06-01', '2020-06-12', N'BaoBD', N'Đã trả', N'Đã trả'),
	(21, N'PS03233', '2020-06-25', '2020-07-08', N'BaoBD', N'Đã trả', N'Đã trả'),
	(22, N'PS12654', '2020-08-01', '2020-08-12', N'BaoBD', N'Đã trả', N'Đã trả'),
	(23, N'PS12345', '2020-09-01', '2020-09-15', N'BaoBD', N'Đã trả', N'Đã trả'),
	(24, N'PS12654', '2020-10-01', '2020-10-12', N'BaoBD', N'Đã trả', N'Đã trả'),--
	(25, N'PS03596', '2020-11-01', '2020-11-15', N'BaoBD', N'Đã trả', N'Đã trả'),
	(26, N'PS03603', '2020-12-01', '2020-12-12', N'BaoBD', N'Đã trả', N'Đã trả'),
	(27, N'PS03610', '2020-11-28', '2020-12-10', N'BaoBD', N'Đã trả', N'Đã trả'),
	(28, N'PS03614', '2020-12-09', '2020-12-20', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(29, N'PS03618', '2020-12-07', '2020-12-21', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(30, N'PS03638', '2020-12-07', '2020-12-21', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(31, N'PS03640', '2020-12-11', '2020-12-24', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(32, N'PS03662', '2020-12-01', '2020-12-15', N'BaoBD', N'Đã trả', N'Quá hạn'),
	(33, N'PS03674', '2020-12-06', '2020-12-20', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(34, N'PS12654', '2020-12-05', '2020-12-20', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(35, N'PS12345', '2020-12-13', '2020-12-26', N'BaoBD', N'Chưa trả', N'Chưa trả'),
	(36, N'PS12654', '2020-12-12', '2020-12-25', N'BaoBD', N'Chưa trả', N'Chưa trả')
GO
SET IDENTITY_INSERT PHIEUMUON OFF
GO
-- Insert bảng CHITIETPM
INSERT CHITIETPM (MaPM, MaSach, TrangThai, SoLuong, GhiChu) VALUES 
	(1, 3, N'Chưa trả', 2, N'Chưa trả'),
	(2, 14, N'Đã trả', 1, N'Đã trả'),
	(2, 4, N'Đã trả', 1, N'Đã trả'),
	(2, 2, N'Đã trả', 1, N'Đã trả'),
	(3, 7, N'Đã trả', 2, N'Đã trả'),
	(3, 1, N'Đã trả', 1, N'Đã trả'),
	(4, 2, N'Đã trả', 1, N'Đã trả'),
	(4, 5, N'Đã trả', 1, N'Đã trả'),
	(5, 4, N'Đã trả', 1, N'Đã trả'),
	(6, 13, N'Đã trả', 2, N'Đã trả'),
	(7, 3, N'Đã trả', 2, N'Đã trả'),
	(8, 11, N'Đã trả', 2, N'Đã trả'),
	(8, 8, N'Đã trả', 2, N'Đã trả'),
	(9, 7, N'Đã trả', 5, N'Đã trả'),
	(10, 3, N'Đã trả', 2, N'Đã trả'),
	(11, 4, N'Đã trả', 1, N'Đã trả'),
	(11, 10, N'Đã trả', 1, N'Đã trả'),
	(12, 7, N'Đã trả', 1, N'Đã trả'),
	(13, 3, N'Đang trả', 2, N'Đã trả'),
	(14, 4, N'Đã trả', 1, N'Đã trả'),
	(15, 7, N'Đã trả', 1, N'Đã trả'),
	(15, 12, N'Đã trả', 1, N'Đã trả'),
	(16, 13, N'Đã trả', 2, N'Đã trả'),
	(16, 9, N'Đã trả', 2, N'Đã trả'),
	(17, 9, N'Đã trả', 1, N'Đã trả'),
	(17, 2, N'Đã trả', 1, N'Đã trả'),
	(18, 7, N'Đã trả', 1, N'Đã trả'),
	(19, 3, N'Đã trả', 2, N'Đã trả'),
	(20, 4, N'Đã trả', 1, N'Đã trả'),
	(21, 7, N'Đã trả', 1, N'Đã trả'),
	(21, 3, N'Đã trả', 1, N'Đã trả'),
	(22, 3, N'Đã trả', 2, N'Đã trả'),
	(23, 4, N'Đã trả', 1, N'Đã trả'),
	(23, 14, N'Đã trả', 1, N'Đã trả'),
	(24, 7, N'Đã trả', 1, N'Đã trả'),
	(25, 3, N'Đã trả', 2, N'Đã trả'),
	(26, 4, N'Đã trả', 1, N'Đã trả'),
	(26, 1, N'Đã trả', 1, N'Đã trả'),
	(26, 7, N'Đã trả', 1, N'Đã trả'),
	(27, 7, N'Đã trả', 1, N'Đã trả'),
	(28, 3, N'Chưa trả', 1, N'Chưa trả'),
	(28, 11, N'Chưa trả', 1, N'Chưa trả'),
	(29, 4, N'Chưa trả', 1, N'Chưa trả'),
	(30, 7, N'Đang trả', 3, N'Trả được 2 cuốn'),
	(31, 4, N'Chưa trả', 1, N'Chưa trả'),
	(32, 4, N'Đã trả', 1, N'Đã trả'),
	(33, 4, N'Chưa trả', 1, N'Chưa trả'),
	(34, 4, N'Chưa trả', 1, N'Chưa trả'),
	(35, 4, N'Chưa trả', 1, N'Chưa trả'),
	(36, 4, N'Chưa trả', 1, N'Chưa trả')
GO
-- store 1
CREATE PROC sp_PhieuMuon
AS BEGIN
	SELECT MaPM, pm.MaSV, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join SINHVIEN sv on pm.MaSV = sv.MaSV
END
GO

-- store 1
CREATE PROC sp_PhieuMuonDT
AS BEGIN
	SELECT MaPM, pm.MaSV, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join SINHVIEN sv on pm.MaSV = sv.MaSV
	where TrangThai like N'Đã trả'
END
GO

-- store 1
CREATE PROC sp_PhieuMuonCT
AS BEGIN
	SELECT MaPM, pm.MaSV, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join SINHVIEN sv on pm.MaSV = sv.MaSV
	where TrangThai like N'Chưa trả'
END
GO

-- store 2
CREATE PROC sp_NgayPM(@ngayBD varchar(50), @ngayKT varchar(50))
AS BEGIN 
 	SELECT MaPM, pm.MaSV, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join SINHVIEN sv on pm.MaSV = sv.MaSV
	where NgayMuon >= @ngayBD and NgayMuon <= @ngayKT
END 
go

-- store 3
CREATE PROC sp_TopSachMuon
AS BEGIN 
	select top 3 s.MaSach,TenSach, Sum(ct.SoLuong) as SL from CHITIETPM ct 
	inner join PHIEUMUON pm on pm.MaPM = ct.MaPM
	inner join SACH s on ct.MaSach = s.MaSach 
	group by TenSach,s.MaSach order by Sum(ct.SoLuong) desc
END 
go

-- store 4
CREATE PROC sp_TopSVMuon
AS BEGIN 
	select top 3 pm.MaSV,HoTen,COUNT(pm.MaPM) as MaPM,COUNT(MaSach) as MaSach from PHIEUMUON pm 
	inner join SINHVIEN sv on pm.MaSV = sv.MaSV
	inner join CHITIETPM ct on pm.MaPM = ct.MaPM
	group by pm.MaSV,HoTen
	order by COUNT(pm.MaPM) desc,COUNT(MaSach) desc
END 
go



-- store 5
CREATE PROC sp_SachMuon(@thang int, @nam int)
AS BEGIN 
	select top 3 s.MaSach,TenSach, Sum(ct.SoLuong) as SL from CHITIETPM ct 
	inner join SACH s on ct.MaSach = s.MaSach 
	inner join PHIEUMUON pm on pm.MaPM = ct.MaPM
	where MONTH(NgayMuon) = @thang and Year(NgayMuon) = @nam
	group by TenSach,s.MaSach order by Sum(ct.SoLuong) desc
END 
go


-- store 6
CREATE PROC sp_SVMuonSach(@thang int, @nam int)
AS BEGIN 
	select top 3 pm.MaSV,HoTen,COUNT(pm.MaPM) as MaPM,COUNT(MaSach) as MaSach from PHIEUMUON pm 
	inner join SINHVIEN sv on pm.MaSV = sv.MaSV
	inner join CHITIETPM ct on pm.MaPM = ct.MaPM
	where MONTH(NgayMuon) = @thang and Year(NgayMuon) = @nam
	group by pm.MaSV,HoTen
	order by COUNT(pm.MaPM) desc,COUNT(MaSach) desc
END 
go

-- store 6
--CREATE PROC sp_CTYear(@nam int)
--AS BEGIN 
--select count(MaSach) as MaSach,MONTH(NgayTra) as NM from CHITIETPM ct 
--inner join  PHIEUMUON pm  on ct.MaPM = pm.MaPM 
--where pm.GhiChu like N'%Quá hạn%' and YEAR(NgayTra) = @nam
--group by MONTH(NgayTra)
--END 
--go

--select count(MaSach) as MaSach,MONTH(NgayTra) as NM from CHITIETPM ct 
--inner join  PHIEUMUON pm  on ct.MaPM = pm.MaPM 
--where pm.GhiChu like N'%Quá hạn%' and Year(NgayTra) = 2020
--group by MONTH(NgayTra)
