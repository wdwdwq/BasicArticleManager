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
			String cmd = sc.nextLine().trim();// 사용자가 입력한 명령어를 받아오고 앞뒤 공백을 제거한 뒤 cmd변수에 저

			if (cmd.length() == 0) {// 입력받은 명령어 길이가 0이라면(아무것도 입력하지 않은 상태)
				System.out.println("명령어를 입력해주세요");// 명령어를 입력해주세요를 출력하고 다시 입력을 받을 준비
				continue;
			}
			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.equals("article write")) {// article write를 입력하면 게시물을 작성할 수 있는데

				lastArticleId++;
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				// lastArticleId를 증가시키고 마지막으로 생성된 게시물 번호를 출력

				Article article = new Article(lastArticleId, title, body);
				// 사용자로부터 제목 내용을 입력 받아 새로운 Article 객체를 생성 articles 리스트에 추가
				//
				articles.add(article);

				System.out.println(lastArticleId + "번 게시물이 생성되었습니다");// 각 게시물 고유한 ID 부
			} else if (cmd.equals("article list")) {// 저장된 게시물 목록을 확인
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다");// 게시물이 없는 경우 "게시물이 존재하지 않습니다" 라는 메시지를 출력
					continue;
				}
				System.out.println("번호		/	제목");
				for (int i = articles.size() - 1; i >= 0; i--) {// 리스트에 저장된 게시물을 역순으로 출력하여 번호와 제목을 표시
					Article article = articles.get(i);
					System.out.printf("%d		/	%s\n", article.id, article.title);

				}

			} else if (cmd.equals("article list")) {// 저장된 게시물 목록을 확인
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다");// 게시물이 없는 경우 "게시물이 존재하지 않습니다" 라는 메시지를 출력
					continue;
				}
				System.out.println("번호		/	제목");
				for (int i = articles.size() - 1; i >= 0; i--) {// 리스트에 저장된 게시물을 역순으로 출력하여 번호와 제목을 표시
					Article article = articles.get(i);
					System.out.printf("%d		/	%s\n", article.id, article.title);

				}

			} else {

				System.out.println("존재하지 않는 명령어 입니다");// 다른 명령어를 입력했을 때는
			}
		}

		System.out.println("==프로그램 종료==");

		sc.close();// Scanner를 닫아 리소스를 해제하고 있다
	}
}

// 현재 article write 라는 명령어를 통해 생성된 게시물들을 실제로 저장할 수 있게 처리하고 
//article list라는 명령어를 통해 저장되어 있는 게시물들의 목록을 볼 수 있게 
//게시물을 저장해둔다 
class Article {// 게시물 클래스
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {// 생성자를 통해 게시물의 정보를 초기화할 수 있
		this.id = id;
		this.title = title;
		this.body = body;

	}
}
