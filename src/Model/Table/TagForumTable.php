<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * TagForum Model
 *
 * @method \App\Model\Entity\TagForum get($primaryKey, $options = [])
 * @method \App\Model\Entity\TagForum newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\TagForum[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\TagForum|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\TagForum patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\TagForum[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\TagForum findOrCreate($search, callable $callback = null, $options = [])
 */
class TagForumTable extends Table
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

        $this->setTable('tag_forum');
        $this->setDisplayField('Forum_ID');
        $this->setPrimaryKey(['Forum_ID', 'Tag_ID']);
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
            ->integer('Forum_ID')
            ->allowEmpty('Forum_ID', 'create');

        $validator
            ->integer('Tag_ID')
            ->allowEmpty('Tag_ID', 'create');

        return $validator;
    }
}
