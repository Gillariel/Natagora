<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountForumComments Model
 *
 * @method \App\Model\Entity\CountForumComment get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountForumComment newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountForumComment[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountForumComment|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountForumComment patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountForumComment[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountForumComment findOrCreate($search, callable $callback = null, $options = [])
 */
class CountForumCommentsTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('count_forum_comments');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        $validator
            ->integer('Forum_ID')
            ->requirePresence('Forum_ID', 'create')
            ->notEmpty('Forum_ID');

        return $validator;
    }
}
