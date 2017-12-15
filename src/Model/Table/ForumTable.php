<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Forum Model
 *
 * @property \App\Model\Table\TagTable|\Cake\ORM\Association\BelongsToMany $Tag
 *
 * @method \App\Model\Entity\Forum get($primaryKey, $options = [])
 * @method \App\Model\Entity\Forum newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\Forum[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Forum|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Forum patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Forum[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\Forum findOrCreate($search, callable $callback = null, $options = [])
 */
class ForumTable extends Table
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

        $this->setTable('forum');
        $this->setDisplayField('ID');
        $this->setPrimaryKey('ID');

        $this->belongsToMany('Tag', [
            'foreignKey' => 'forum_id',
            'targetForeignKey' => 'tag_id',
            'joinTable' => 'tag_forum'
        ]);
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
            ->integer('ID')
            ->allowEmpty('ID', 'create');

        $validator
            ->integer('Likes')
            ->requirePresence('Likes', 'create')
            ->notEmpty('Likes');

        $validator
            ->integer('Dislike')
            ->requirePresence('Dislike', 'create')
            ->notEmpty('Dislike');

        $validator
            ->integer('Session_ID')
            ->requirePresence('Session_ID', 'create')
            ->notEmpty('Session_ID');

        return $validator;
    }
}
