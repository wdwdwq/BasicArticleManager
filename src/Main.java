import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.equals("article write")) {

				lastArticleId++;

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(lastArticleId, Util.getDateStr(), title, body);

				articles.add(article);

				System.out.println(lastArticleId + "번 게시물이 생성되었습니다");
			} else if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다");
					continue;
				}

				System.out.println("번호	/	제목	/		작성일");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	/	%s	/	%s\n", article.id, article.title, article.regDate);
				}

			} else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);

				Article foundArticle = null;

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}

				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("작성일 : %s\n", foundArticle.regDate);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);

			} else if (cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);

				Article foundArticle = null;

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}

				articles.remove(foundArticle);
				System.out.printf("%d번 게시물을 삭제했습니다\n", id);

			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}

		System.out.println("== 프로그램 끝 ==");

		sc.close();

	}
}
//날짜 데이터 적용
// 날짜 데이터가 저장되는 시점
// 게시물이 작성하면 알아서 현재 시간 날짜로 저장
// article write했을 때 
//알아서 날짜와 시간 데이터가 Article객체로 같이 저장
//자바에서 현재 날짜와 시간을 알아올 수 있는 방법

class Article {
	int id;
	String regDate;
	String title;
	String body;

	Article(int id,String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}

}