# Уведомления Bitbucket в Telegram

Это приложение позволит вам получать уведомления о событиях в вашем Bitbucket Server.

За основу взята серверная версия этого приложения: https://github.com/uPagge/bitbucketbot

## Возможности бота
1. Уведомление о новых PullRequest, в которых вас назначили ревьювером.
<p align="center">
<img src="img/img1.jpg" width=48% alt="Уведомление о новых PullRequest">
</p>

2. Уведомление о возникновении конфликта в вашем PullRequest
<p align="center">
<img alt="Уведомление о возникновении конфликта в PullRequest" src="img/img3.jpg" width=48%>
</p>

3. Уведомление об изменениях в статусах ревьюверов к вашему PullRequest
<p align="center">
<img alt="Уведомление об изменениях в статусах ревьюверов к вашему PullRequest" src="img/img5.jpg" width=48%>
</p>

4. Уведомление об изменении статуса вашего ПР (мерж, удаление, деклайн)
<p align="center">
<img alt="Уведомление об изменении статуса вашего ПР (мерж, удаление, деклайн)" src="img/img4.jpg" width=48%>
</p>

5. Уведомление о добавлении и удалении ревьюверов в вашем PullRequest
<p align="center">
<img alt="Уведомление о добавлении и удалении ревьюверов в вашем PullRequest" src="img/img6.jpg" width=48%>
</p>

6. Уведомление о создании задачи средствами Bitbucket в ваш PullRequest
<p align="center">
<img alt="Уведомление о создании задачи средствами Bitbucket в ваш PullRequest" src="img/img2.jpg" width=48%>
</p>

7. Уведомление об обновлении PR, в котором вы ревьювер
<p align="center">
<img alt="Уведомление о создании задачи средствами Bitbucket в ваш PullRequest" src="img/img9.jpg" width=48%>
</p>

8. Уведомление о новом комментарии в вашем ПР
<p align="center">
<img alt="Уведомление о новом комментарии в вашем ПР" src="img/img8.jpg" width=48%>
</p>

9. Напоминания о просмотре PR. Это попытка создать умную систему уведомлений, которая будет ненавязчиво 
напоминать, что PR давно не просматривался. Например если прошло 2 часа, а вы так и не приняли решение, 
или если прошло уже 4 часа и кто-то вынес свое решение, а вы еще нет. Механизм еще будет дорабатываться.
<p align="center">
<img alt="Уведомление о новом комментарии в вашем ПР" src="img/img7.jpg" width=48%>
</p>

## Запуск

### Docker
Для запуска можно использовать докер: https://hub.docker.com/r/upagge/bitbucket-bot-local