import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어)");
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
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(lastArticleId, title, body);

				articles.add(article);

				System.out.println(lastArticleId + "번 게시물이 생성되었습니다");
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다");
					continue;
				}
				System.out.println("번호		/	제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d		/	%s\n", article.id, article.title);

				}

			} else if (cmd.startsWith("article detail")) {
				String[] cmdBits = cmd.split(" ");//입력된 명령어 공백 단위로 나누어 배열에 저장 공백을 기준으로 나
				int id = Integer.parseInt(cmdBits[2]);//보고자 하는 게시물의 번호가 들어가게 되는데 it타입으로 파싱하여 저

				Article foundArticle = null;

				for (Article article : articles) {//for 루프 사용 articles리스트 순회해 입력받은 번호화 일치하는 게시물을 찾
					if (article.id == id) {//일치하는 게시물이 있으면 해당 내용 출력 
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);//없으면 게시물이 존재하지 않습니다 메시지 출력
					continue;
				}

				System.out.printf("번호  :  %d\n", foundArticle.id);
				System.out.printf("제목  :  %s\n", foundArticle.title);
				System.out.printf("내용  :  %s\n", foundArticle.body);

			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}

		System.out.println("==프로그램 종료==");

		sc.close();
	}
}
//명령어 분기 타는 else if
//article detail 이런 명령이 들어왔을 때 starsWith() 사용해서 올바르게 인지할 수 있게끔
//명령어에 입력된 글 번호 부분을 split() 활용해서 변수에 저장
//articles 안에 내가 보고자 하는 글의 번호화 일치하는 게시물이 있는지 찾아봐야한다(순회해서 찾는다)
//찾아봤는데 없으면 메시지
//찾음 다음에 있으면 보여줌

class Article {
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;

	}
}